window.addEventListener('load', function () {
    const formulario = document.querySelector('#actualizar');
    formulario.addEventListener('submit', (e) => {
        e.preventDefault();
        const formData = {
            id: document.querySelector('#turnoId').value,
            pacienteId: document.querySelector('#pacienteId').value,
            odontologoId: document.querySelector('#odontologoId').value,
            fecha: document.querySelector('#fecha').value,

        };
        const url = '/turno';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
        fetch(url,settings)
        .then(response => {
            if (response.status == 404){
                alert("Las modificaciones no fueron ejecutadas");
            }
            window.location.replace("/get_list_turnos.html");
        })

    })
 });

function findBy(id) {
    const url = '/turno'+"/"+id;
    const settings = {
        method: 'GET'
    }
    fetch(url,settings)
    .then(response => response.json())
    .then(data => {
        let turno = data;
        document.querySelector('#turnoId').value = id;
        document.querySelector('#fecha').value = turno.fecha;
        document.querySelector('#pacienteId').value = turno.pacienteId;
        document.querySelector('#odontologoId').value = turno.odontologoId;
        document.querySelector('#divActualizar').style.display = "block";
        })
    .catch(error => {
        alert("Error: " + error);
    })
}

