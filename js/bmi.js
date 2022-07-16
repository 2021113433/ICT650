function calculate()
{
var weight = document.getElementById("weight").value;
var height = document.getElementById("height").value;

var obese1= "Underweight And Malnutrition Risk";
var obese2= "Normal Weight And Low Risk";
var obese3= "Overweight And Enhanced Risk";
var obese4= "Moderately Obese And Medium Risk";
var obese5= "Severely Obese And High Risk";
var obese6= "Very Severely Obese Very High Risk";
var result = height % 1 != 0;
	if (result == 0) //already in cm
	{
		var cm = height/100;
		var bmi = weight/(cm*cm);
	}
	else //already in m
	{
		var bmi = weight/(height*height);
	}
	
document.getElementById("BMI").value=bmi.toFixed(2);

	if(bmi <= 18.4)
	{
		document.getElementById("message").innerHTML=obese1;
	}
	else
	{
		if(bmi >= 18.5 && bmi <= 24.9)
		{
			document.getElementById("message").innerHTML=obese2;
		}
		else
		{
			if(bmi >= 25 && bmi <= 29.9)
			{
				document.getElementById("message").innerHTML=obese3;
			}
			else
			{
				if(bmi >= 30 && bmi <= 34.9)
				{
				   document.getElementById("message").innerHTML=obese4;
				}
				else
				{
					if(bmi >= 35 && bmi <= 39.9)
					{
						document.getElementById("message").innerHTML=obese5;
					}
					else
					{
						if(bmi >= 40)
						{
							document.getElementById("message").innerHTML=obese6;
						}
					}
				}
			}
		}
	}
	
}

