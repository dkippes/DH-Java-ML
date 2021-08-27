package main

import "fmt"

type Alumno struct {
	nombre   string
	apellido string
	dni      int
	fecha    string
}

func (a Alumno) Detalle() {

	fmt.Printf("\nDetalle del alumno:")
	fmt.Printf("\nNombre: %s \nApellido: %s \nDNI: %v \nFecha: %s\n", a.nombre, a.apellido, a.dni, a.fecha)

}

func main() {

	alumno := Alumno{
		nombre:   "Carlos",
		apellido: "Molina",
		dni:      95866074,
		fecha:    "25/10/2023",
	}

	alumno2 := Alumno{
		nombre:   "Pablo",
		apellido: "Gonzalez",
		dni:      36564453,
		fecha:    "29/01/2015",
	}

	Alumno.Detalle(alumno)
	Alumno.Detalle(alumno2)

}
