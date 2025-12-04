let points = 2000;
let total = 6000;
document.getElementById("pointCount").innerText = points + " / " + total;
function updateBar() {
  let percent = (points / total) * 100;
  document.getElementById("progress").style.width = percent + "%";
}

// Call immediately when page loads
updateBar();
