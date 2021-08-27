package main

import (
	"errors"
	"fmt"
)

func main() {

	const (
		minimo   = "minimo"
		promedio = "promedio"
		maximo   = "maximo"
	)

	minFunc, err := operacion(minimo)
	promFunc, err := operacion(promedio)
	maxFunc, err := operacion(maximo)

	if err != nil {
		fmt.Println(err)
	}

	valorMinimo := minFunc(2, 3, 3, 4, 10, 2, 4, 5)
	valorPromedio := promFunc(2, 3, 3, 4, 1, 2, 4, 5)
	valorMaximo := maxFunc(2, 3, 3, 4, 1, 2, 4, 5)

	fmt.Println("La calificacion con menor puntuacion es:", valorMinimo)
	fmt.Println("El promedio de las calificaciones es:", valorPromedio)
	fmt.Println("La calificacion con mayor puntuacion es:", valorMaximo)

}

func calcularMunimo(num ...int) int {
	var numMinimo int = 10000
	for _, valor := range num {
		if valor < numMinimo {
			numMinimo = valor
		}
	}
	return numMinimo
}

func calcularPromedio(num ...int) int {
	var promedio int
	var suma int
	for _, valor := range num {
		suma += valor
	}
	promedio = suma / len(num)
	return promedio
}

func calcularMaximo(num ...int) int {
	var numMaximo int
	for _, valor := range num {
		if valor > numMaximo {
			numMaximo = valor
		}
	}
	return numMaximo
}

func operacion(calculo string) (func(...int) int, error) {

	switch calculo {
	case "minimo":
		numeroMinimo := calcularMunimo
		return numeroMinimo, nil
	case "promedio":
		numeroPromedio := calcularPromedio
		return numeroPromedio, nil
	case "maximo":
		numeroMaximo := calcularMaximo
		return numeroMaximo, nil
	default:
		return nil, errors.New("La operacion a realizar no existe.")
	}
}
