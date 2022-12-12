window.addEventListener('load', function () {

    //Al cargar la pagina buscamos y obtenemos el formulario donde estarán
    //los datos que el usuario cargará de la nueva pelicula
    const formulario = document.querySelector('#postPaciente');

    //Ante un submit del formulario se ejecutará la siguiente funcion
    formulario.addEventListener('submit', function (event) {
        event.preventDefault();

       //creamos un JSON que tendrá los datos de la nueva película
        const formData = {
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            dni: document.querySelector('#dni').value,
            fechaIngreso: document.querySelector('#fechaIngreso').value,
            email: document.querySelector('#email').value,
            domicilio:{
                calle: document.querySelector('#calle').value,
                numero: document.querySelector('#numeroDomicilio').value,
                localidad: document.querySelector('#localidadDomicilio').value,
                provincia: document.querySelector('#provinciaDomicilio').value,
            }
        };

        const url = '/paciente';
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

                 let mensaje = '<h4>Paciente registrado</h4>';
                 document.querySelector('.mensaje').innerHTML = mensaje;
                 resetUploadForm();
            })
            .catch(error => {

                let mensajeError = '<h4>No se ha podido registrar el paciente</h4>';

                document.querySelector('.mensaje').innerHTML = mensajeError;
                resetUploadForm();
            })
    });


    function resetUploadForm(){
        document.querySelector('#nombre').value = "";
        document.querySelector('#apellido').value = "";
        document.querySelector('#dni').value = "";
        document.querySelector('#fechaIngreso').value = "";
        document.querySelector('#email').value = "";
        document.querySelector('#calle').value = "";
        document.querySelector('#numeroDomicilio').value = "";
        document.querySelector('#localidadDomicilio').value = "";
        document.querySelector('#provinciaDomicilio').value = "";
    }

});
