let plus = document.querySelector(".plus");
let mius = document.querySelector(".minus");
let result = document.querySelector("#result");
let totalcost = document.querySelector(".totalcost");
let i = 1;

plus.addEventListener("click", () =>{
	i++
	result.textContent = i;
	let totalcostNum = i*45000;
	totalcost.textContent = "|" + totalcostNum.toLcaleString();
})

mius.addEventListener("click", () =>{
	if(i>0){
		i--
		result.textContent = i;
		let totalcostNum = i * 45000;
		totalcost.textContent = "|" + totalcostNum.toLocaleString();
	}
	else {
		totalcost.textContent = "|" + 0
	}
})


$(document).ready(function() {
		$('.slider').slick({
			autoplay : true,
			autoplaySpeed : 1000,
			slidesToShow : 3,
			slidesToScroll : 1,
			arrows : true
		});

	});