window.addEventListener('load', function () {
    const url = '/turno';
    const settings = {
        method: 'GET'
    }
    fetch(url,settings)
    .then(response => response.json())
    .then(data => {

        for(turno of data){

            const tabla = document.getElementById("tablaTurno");
            const fila = `<tr class="celdas" id="tr${turno.id}">
                            <td>${turno.id}</td>
                            <td>${turno.pacienteId}</td>
                            <td>${turno.odontologoId}</td>
                            <td>${turno.fecha}</td>
                            <td><button id ="btn_id_${turno.id}" onclick=findBy(${turno.id})>📋</button></td>
                            <td><button id ="btn_delete_${turno.id}" onclick=deleteBy(${turno.id})>❌</button></td>
                        </tr>`
            tabla.innerHTML += fila;
        };
    })

});