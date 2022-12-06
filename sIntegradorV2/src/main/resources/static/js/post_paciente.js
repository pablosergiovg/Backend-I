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
            dni: document.querySelector('#documento').value,
            fechaIngreso: document.querySelector('#fechaIngreso').value,
            email: document.querySelector('#email').value,
            domicilio:{
                calle: document.querySelector('#calle').value,
                numero: document.querySelector('#numeroDomicilio').value,
                localidad: document.querySelector('#localidadDomicilio').value,
                provincia: document.querySelector('#provinciaDomicilio').value,
            }
        };


        //invocamos utilizando la función fetch la API peliculas con el método POST que guardará
        //la película que enviaremos en formato JSON
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
                 //Si no hay ningun error se muestra un mensaje diciendo que la pelicula
                 //se agrego bien
                 let mensaje = '<h4>Paciente registrado</h4>';
                 document.querySelector('.mensaje').innerHTML = mensaje;
                 resetUploadForm();
            })
            .catch(error => {
                    //Si hay algun error se muestra un mensaje diciendo que la pelicula
                    //no se pudo guardar y se intente nuevamente
                    let mensajeError = '<h4>No se ha podido registrar el paciente</h4>';

                     document.querySelector('.mensaje').innerHTML = mensajeError;
                     resetUploadForm();})
    });


    function resetUploadForm(){
        document.querySelector('#nombre').value = "";
        document.querySelector('#apellido').value = "";
        document.querySelector('#documento').value = "";
        document.querySelector('#fechaIngreso').value = "";
        document.querySelector('#email').value = "";
        document.querySelector('#calle').value = "";
        document.querySelector('#numeroDomicilio').value = "";
        document.querySelector('#localidadDomicilio').value = "";
        document.querySelector('#provinciaDomicilio').value = "";
    }

    /*(function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            document.querySelector(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/peliculaList.html") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }
    })();*/
});
