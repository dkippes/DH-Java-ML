package main

import (
	"fmt"
)

func main() {

	var (
		edad       int = 23
		antiguedad int = 2
		sueldo     int = 120000
	)

	var (
		edad_22años     int = 22
		antiguedad_1año int = 1
		sueldo_100mil   int = 100000
	)

	switch {
	case edad < edad_22años:
		fmt.Println("Debes tener 22 años para solicitar un credito.")
	case antiguedad < antiguedad_1año:
		fmt.Println("Tu antiguedad debe ser de un año para solicitar un credito.")
	case sueldo < sueldo_100mil:
		fmt.Println("Tu sueldo debe ser de 100 mil para solicitar un credito.")
	default:
		fmt.Println("Cumples con todos los requisitos para tu credito.")
	}

}
