window.addEventListener('load', function () {
    const formulario = document.querySelector('#actualizar');
    formulario.addEventListener('submit', function (event) {

        let odontologoId = document.querySelector('#odontologo_id').value;

        const formData = {
            id: document.querySelector('#odontologo_id').value,
            matricula: document.querySelector('#matricula').value,
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value
        };

        const url = '/odontologo';
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
                window.location.replace("/get_list_odontologos.html");
            })
    })
 })

function findBy(id) {
    const url = '/odontologo'+"/"+id;
    const settings = {
        method: 'GET'
    }
    fetch(url,settings)
    .then(response => response.json())
    .then(data => {
        let odontologo = data;
        document.querySelector('#odontologo_id').value = id;
        document.querySelector('#matricula').value=odontologo.matricula;
        document.querySelector('#nombre').value=odontologo.nombre;
        document.querySelector('#apellido').value=odontologo.apellido;
        document.querySelector('#divActualizar').style.display = "block";
    }).catch(error => {
    alert("Error: " + error);
    })
}