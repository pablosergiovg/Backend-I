function deleteBy(id){
    const url='/paciente/'+id;
    const settings={
        method:'DELETE'
    }
    fetch(url,settings)
    .then(response => {
        let fila = "#tr" + id;
        document.querySelector(fila).remove();
    }).catch(error => {
        let mensajeError = '<h4>No se ha podido eliminar el paciente</h4>';
        document.querySelector('.mensaje').innerHTML = mensajeError;
    })
}