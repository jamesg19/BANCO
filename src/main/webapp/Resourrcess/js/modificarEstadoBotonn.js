function bloquearBoton(boton) {
    boton.classList.add('selected');
    boton.disabled = true;

}
function activarBoton(boton, rutaImg) {
    boton.classList.remove('selected');
    boton.disabled = false;
    
}