window.addEventListener('load', function () {
    const url = '/paciente';
    const settings = {
        method: 'GET'
    }
    fetch(url,settings)
    .then(response => response.json())
    .then(data => {
    console.log(data);

        for(paciente of data){

            const tabla = document.getElementById("tablaPaciente");
            const fila = `<tr class="celdas" id="tr${paciente.id}">
                            <td>${paciente.id}</td>
                            <td>${paciente.nombre.toUpperCase()}</td>
                            <td>${paciente.apellido.toUpperCase()}</td>
                            <td>${paciente.dni}</td>
                            <td>${paciente.fechaIngreso}</td>
                            <td>${paciente.email}</td>
                            <td><button id ="btn_id_${paciente.id}" onclick=findBy(${paciente.id})>📋</button></td>
                            <td><button id ="btn_delete_${paciente.id}" onclick=deleteBy(${paciente.id})>❌</button></td>
                        </tr>`
            tabla.innerHTML += fila;
        };
    })
});