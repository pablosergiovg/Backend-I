window.addEventListener('load', function () {
    const url = '/odontologo';
    const settings = {
        method: 'GET'
    }
    fetch(url,settings)
    .then(response => response.json())
    .then(data => {
    console.log(data);

        for(odontologo of data){

            const tabla = document.getElementById("tablaOdontologo");
            const fila = `<tr class="celdas" id="tr${odontologo.id}">
                            <td>${odontologo.id}</td>
                            <td>${odontologo.matricula}</td>
                            <td>${odontologo.nombre.toUpperCase()}</td>
                            <td>${odontologo.apellido.toUpperCase()}</td>
                            <td><button id ="btn_id_${odontologo.id}" onclick=findBy(${odontologo.id})>📋</button></td>
                            <td><button id ="btn_delete_${odontologo.id}" onclick=deleteBy(${odontologo.id})>❌</button></td>
                        </tr>`
            tabla.innerHTML += fila;
        };
    })

});