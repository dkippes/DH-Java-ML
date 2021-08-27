package main

import (
	"errors"
	"fmt"
)

func main() {

	var (
		//Ingresar la cantidad de minitus trabajados.
		minTrabajados float64 = 500
		// Agregar el valor de la caregoria A, B ,C.
		categoria string = "A"
	)

	salario, err := calcularSalario(minTrabajados, categoria)

	if err != nil {
		fmt.Println(err)
	} else {
		fmt.Println("Calculo del sueldo:", salario)
	}

}

func calcularSalario(minMensuales float64, categoria string) (float64, error) {

	var totalSalario float64
	var salario float64
	var porcentaje float64

	if minMensuales <= 0 {
		return 0, errors.New("Debes agregar la cantidad de minitos trabajados")
	}

	if categoria == "" {
		return 0, errors.New("Debes agregar una caregoria en la que se encuentra el empleado")
	}

	if categoria == "C" {
		totalSalario = minMensuales * 16.66
	} else if categoria == "B" {
		salario = minMensuales * 25
		porcentaje = (salario / 100) * 20
		totalSalario = porcentaje + salario
	} else if categoria == "A" {
		salario = minMensuales * 50
		porcentaje = (salario / 100) * 50
		totalSalario = porcentaje + salario
	}

	return totalSalario, nil

}
