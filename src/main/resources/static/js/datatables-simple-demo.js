window.addEventListener('DOMContentLoaded', event => {
  const datatablesSimple = document.getElementById('datatablesSimple');
  if (datatablesSimple) {
    new simpleDatatables.DataTable(datatablesSimple);
    datatablesSimple.style.opacity = '1';
  }
});

window.addEventListener('DOMContentLoaded', event => {
  const container = document.querySelector('.fouc');
  if (container) {
    container.classList.add('show');
  }
});

