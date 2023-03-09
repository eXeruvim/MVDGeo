function toggleDisabled() {
   let inputFields = document.querySelectorAll('.form-control');
   for (let input of inputFields) {
      if (input.hasAttribute('disabled')) {
         input.removeAttribute('disabled');
      } else {
         input.setAttribute('disabled', true);
      }
      toggleButtons()
   }
}

function toggleButtons(){
   let editButton = document.querySelector('.edit-button');
   let saveButton = document.querySelector('.save-button');
   let cancelButton = document.querySelector('.cancel-button');

   if (editButton.style.display === 'none') {
      editButton.style.display = 'block';
      saveButton.style.display = 'none';
      cancelButton.style.display = 'none';
   } else {
      editButton.style.display = 'none';
      saveButton.style.display = 'block';
      cancelButton.style.display = 'block';
   }
}

function toggleType(target, cls){
   var input = document.querySelector(cls);
   if (input.getAttribute('type') === 'password') {
      target.classList.add('view');
      input.setAttribute('type', 'text');
   } else {
      target.classList.remove('view');
      input.setAttribute('type', 'password');
   }
   return false;
}

function validate(e){
   let p = document.querySelector('#pv1');
   if (!(/[0-9]/.test(e.value))) p.style.color = 'red';
   else p.style.color = 'green';
   p = document.querySelector('#pv2');
   if (!(/[!#$%&?]/.test(e.value))) p.style.color = 'red';
   else p.style.color = 'green';
   p = document.querySelector('#pv3')
   if (!(/[a-z]/.test(e.value))) p.style.color = 'red';
   else p.style.color = 'green';
   p = document.querySelector('#pv4');
   if (!(/[A-Z]/.test(e.value))) p.style.color = 'red';
   else p.style.color = 'green';
   p = document.querySelector('#pv5');
   if ((/\s/.test(e.value))) p.style.color = 'red';
   else p.style.color = 'green';
   p = document.querySelector('#pv6');
   if ((/.{6,18}/.test(e.value))) p.style.color = 'green';
   else p.style.color = 'red';

}