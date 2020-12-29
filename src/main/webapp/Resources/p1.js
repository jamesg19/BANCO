/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function ocultarR(cont){
    $('#pdf'+cont).prop("required", false);
    document.getElementById('actualizaPDF'+cont).style.display = 'none';
}

function mostarR(cont){
    $('#pdf'+cont).prop("required", true);
    document.getElementById('actualizaPDF'+cont).style.display = 'block';
    
}