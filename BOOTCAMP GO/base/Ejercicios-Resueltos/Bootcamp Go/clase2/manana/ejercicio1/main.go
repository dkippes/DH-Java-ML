package main

import (
	"fmt"
)

func main() {

	var sueldo float64 = 150000

	impuesto := impuestosSueldos(sueldo)

	fmt.Print("Inpuesto a descontar:", impuesto)
}

func impuestosSueldos(sueldo float64) float64 {

	var impuesto float64

	if sueldo > 50000 && sueldo <= 149000 {
		impuesto = (sueldo / 100) * 17
	} else if sueldo >= 150000 {
		impuesto = (sueldo / 100) * 27
	}

	return impuesto
}
