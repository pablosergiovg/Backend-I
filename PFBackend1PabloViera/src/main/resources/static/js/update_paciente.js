window.addEventListener('load', function () {
    const formulario = document.querySelector('#actualizar');
    formulario.addEventListener('submit', function (event) {

        event.preventDefault();
        let pacienteId = document.querySelector('#paciente_id').value;

        const formData = {
            id: document.querySelector('#paciente_id').value,
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            dni: document.querySelector('#dni').value,
            fechaIngreso: document.querySelector('#fechaIngreso').value,
            email: document.querySelector('#email').value,
            domicilio:{
                            id: document.querySelector('#domicilio_id').value,
                            calle: document.querySelector('#calle').value,
                            numero: document.querySelector('#numeroDomicilio').value,
                            localidad: document.querySelector('#localidadDomicilio').value,
                            provincia: document.querySelector('#provinciaDomicilio').value,
                            }
        };

        const url = '/paciente';
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
            window.location.replace("/get_list_pacientes.html");
        })
    })
 })

function findBy(id) {
    const url = '/paciente'+"/"+id;
    const settings = {
        method: 'GET'
    }
    fetch(url,settings)
    .then(response => response.json())
    .then(data => {
        let paciente = data;
        document.querySelector('#paciente_id').value = id;
        document.querySelector('#nombre').value=paciente.nombre;
        document.querySelector('#apellido').value=paciente.apellido;
        document.querySelector('#dni').value=paciente.dni;
        document.querySelector('#fechaIngreso').value=paciente.fechaIngreso;
        document.querySelector('#email').value=paciente.email;
        document.querySelector('#domicilio_id').value=paciente.domicilio.id;
        document.querySelector('#calle').value=paciente.domicilio.calle;
        document.querySelector('#numeroDomicilio').value=paciente.domicilio.numero;
        document.querySelector('#localidadDomicilio').value=paciente.domicilio.localidad;
        document.querySelector('#provinciaDomicilio').value=paciente.domicilio.provincia;
        document.querySelector('#divActualizar').style.display = "block";
    }).catch(error => {
    alert("Error: " + error);
    })
}