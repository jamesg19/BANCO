var elementoDialog = document.querySelector("#PrimerEjemploDialog dialog"),
    mostrarDialogo = document.querySelector("#PrimerEjemploDialog button"),
    cerrarDialogo = document.querySelector("#PrimerEjemploDialog dialog button");

/**
 * Solamente si se usa el polyfill
 */
if( dialogPolyfill ) {
  dialogPolyfill.registerDialog(elementoDialog);
}

/**
 * Evento para mostrar el dialogo
 */
mostrarDialogo.addEventListener("click", function(e) {
  e.preventDefault();

  /**
   * Defensivamente comprobamos si la propiedad showModal existe en la selección elementoDialog y si esta es una función.
   */
  if( elementoDialog.hasOwnProperty("showModal") && typeof elementoDialog.showModal == "function" ) {

    /**
     * En ese caso SI estamos usando en polyfill
     */
    elementoDialog.showModal();

  /* En caso de NO usar el polyfill sería elementoDialog.show(); */
  } else {
    elementoDialog.show();
  }
}, false);

/**
 * Evento para cerrar el dialogo
 */
cerrarDialogo.addEventListener("click", function(e) {
  e.preventDefault();
  elementoDialog.close();
}, false);