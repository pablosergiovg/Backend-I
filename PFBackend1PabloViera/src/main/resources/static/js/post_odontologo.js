window.addEventListener('load', function () {

    const formulario = document.querySelector('#postOdontologo');

    formulario.addEventListener('submit', function (event) {
        event.preventDefault();

        const formData = {
            matricula: document.querySelector('#matricula').value,
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
        };

        const url = '/odontologo';
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
                 let mensaje = '<h4>Odontologo registrado</h4>';
                 document.querySelector('.mensaje').innerHTML = mensaje;
                 resetUploadForm();
            })
            .catch(error => {
                    let mensajeError = '<h4>No se ha podido registrar el Odontologo</h4>';
                    document.querySelector('.mensaje').innerHTML = mensajeError;
                    resetUploadForm();})
    });


    function resetUploadForm(){
        document.querySelector('#matricula').value = "";
        document.querySelector('#nombre').value = "";
         document.querySelector('#apellido').value = "";
    }

});