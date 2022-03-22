
let url='http://localhost:8080/rest/msdxc/dxc?sueldo=@sueldo&ahorro=@ahorro';
//let url='http://72.167.54.69:8080/rest/msdxc/dxc?sueldo=@sueldo&ahorro=@ahorro'

function Limpiar(){
    document.getElementById("Resultado").innerHTML="";
    document.getElementById("DivError").style.display = "none";
}
function Calcular10xCiento(){
    
    document.getElementById("DivError").style.display = "none";
    document.getElementById("Resultado").innerHTML="";
    if(document.getElementById('sueldo_actual').value<=0)
    {
        document.getElementById("DivError").style.display = "";
        document.getElementById("Error").innerHTML="Ingresar sueldo actual";
        return false;
    }
    if(document.getElementById('monto_ahorrado').value<=0)
    {
        document.getElementById("DivError").style.display = "";
        document.getElementById("Error").innerHTML="Ingresar monto ahorrado";
        return false;
    }
    let urlParametros=url;
    urlParametros=urlParametros.replace('@sueldo',document.getElementById('sueldo_actual').value);
    urlParametros=urlParametros.replace('@ahorro',document.getElementById('monto_ahorrado').value);
    
    $.get(urlParametros).done(function(datos,status) {
        
        document.getElementById("Resultado").innerHTML=
        "<table>"+
        "<tr>"+
        "<tr><td>El monto a retirar es </td><td> $"+datos.dxc+"</td></tr>"+
        "<tr><td>El saldo restante de ahorro es </td><td> $"+datos.saldo+"</td></tr>"+
        "<tr><td>El impuesto a pagar es </td><td> $"+datos.impuesto+"</td></tr>"+
        "</table>"
    }).fail(function(xhr, status, error){
        document.getElementById("DivError").style.display = "";
        document.getElementById("Error").innerHTML="Se produjo un error";
    })
      
    
    
}

