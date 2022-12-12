window.addEventListener('load', function () {
    const formulario = document.querySelector('#postTurno');

    formulario.addEventListener('submit', (e) => {

        console.log(e)
        e.preventDefault();
        const formData = {
            pacienteId: document.querySelector('#pacienteId').value,
            odontologoId: document.querySelector('#odontologoId').value,
            fecha: document.querySelector('#fecha').value
        };

        const url = '/turno';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {

                let mensaje = '<h4>Turno registrado</h4>';
                document.querySelector('.mensaje').innerHTML = mensaje;
                resetUploadForm();

            })
            .catch(error => {

                let mensajeError = '<h4>No se ha podido registrar el Turno</h4>';
                document.querySelector('.mensaje').innerHTML = mensajeError;
                resetUploadForm();
            })
    });


    const resetUploadForm = () => {
        document.querySelector('#pacienteId').value = "";
        document.querySelector('#odontologoId').value = "";
        document.querySelector('#fecha').value = "";
    }

});

