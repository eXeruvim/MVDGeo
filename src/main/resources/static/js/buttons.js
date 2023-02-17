function toggleDisabled(input) {
   if (input.hasAttribute('disabled')) {
      input.removeAttribute('disabled');
      input.focus();
   } else {
      input.setAttribute('disabled', true);
   }
}
