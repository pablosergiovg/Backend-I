function deleteBy(id){
    const url='/paciente/'+id;
    const settings={
        method:'DELETE'
    }
    fetch(url,settings)
    .then(response=> response.json())

    //eliminar la fila de la tabla
        let row_id = "#tr_" + id;
        document.querySelector(row_id).remove();
}