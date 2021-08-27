package main

import (
	"fmt"
)

func main() {

	var empleados = map[string]int{
		"Benjamin": 20,
		"Nahuel":   30,
		"Brenda":   19,
		"Darío":    44,
		"Pedro":    30,
	}

	fmt.Println("Edad de Benjamin:", empleados["Benjamin"])

	for key, value := range empleados {
		if value >= 21 {
			fmt.Println("Personas que tienen 21 años o mas en la empresa:", key)
		}
	}

	fmt.Println("Agregando el Empleado con nombre Federico")
	empleados["Federico"] = 25

	fmt.Println("Eliminando el Empleado con nombre Pedro")
	delete(empleados, "Pedro")

	fmt.Println(empleados)

}
