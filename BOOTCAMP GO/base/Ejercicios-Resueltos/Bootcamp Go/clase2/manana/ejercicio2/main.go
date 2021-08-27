package main

import (
	"errors"
	"fmt"
)

func main() {

	//promedio, err := promedioAlumnos(2, 4, -5, 8, 2)
	promedio, err := promedioAlumnos(2, 4, 5, 8, 2)

	if err != nil {
		fmt.Println(err)
	} else {
		fmt.Println("El promedio del alumno es:", promedio)
	}

}

func promedioAlumnos(notas ...int) (int, error) {

	var resultado int
	var promedio int

	for _, value := range notas {
		if value < 0 {
			return 0, errors.New("Hay numeros negativos en las calificaciones")
		} else {
			resultado += value
		}
	}

	promedio = resultado / len(notas)

	return promedio, nil

}
