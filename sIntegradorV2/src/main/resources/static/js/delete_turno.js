function deleteBy(id){
    const url='/turno/'+id;
    const settings={
        method:'DELETE'
    }
    fetch(url,settings)
    .then(response => {
        let fila = "#tr" + id;
        document.querySelector(fila).remove();
    }).catch(error => {
        let mensajeError = '<h4>No se ha podido eliminar el turno</h4>';
        document.querySelector('.mensaje').innerHTML = mensajeError;
    })
}