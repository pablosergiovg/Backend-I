function deleteBy(id){
    const url='/odontologo/'+id;
    const settings={
        method:'DELETE'
    }
    fetch(url,settings)
    .then(response => {
        let fila = "#tr" + id;
        document.querySelector(fila).remove();
    }).catch(error => {
        let mensajeError = '<h4>No se ha podido eliminar el odontologo</h4>';
        document.querySelector('.mensaje').innerHTML = mensajeError;
    })
}