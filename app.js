fetch("halls").then(r=>r.json()).then(halls=>{
 const box=document.getElementById("halls");
 box.innerHTML=halls.map(h=>`<div class="hall"><h2>${h.name}</h2><p>📍 ${h.location}</p><p>👥 Capacity: ${h.capacity}</p><p>💰 ₹${h.price.toLocaleString()}</p><a class="btn" href="booking.html?hallId=${h.id}">Book Hall #${h.id}</a></div>`).join("");
}).catch(()=>document.getElementById("halls").innerHTML="<p>Unable to load halls. Check database/server.</p>");