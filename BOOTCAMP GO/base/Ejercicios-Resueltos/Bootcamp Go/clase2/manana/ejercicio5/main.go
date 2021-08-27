package main

import (
	"errors"
	"fmt"
)

func main() {
	const (
		perro     = "perro"
		gato      = "gato"
		hamster   = "hamster"
		tarantula = "tarantula"
	)

	animalPerro, err := animal(perro)
	animalGato, err := animal(gato)
	animalHamster, err := animal(hamster)
	animalTarantula, err := animal(tarantula)

	if err != nil {
		fmt.Println(err)
	}

	var cantidad float64
	cantidad += animalPerro(10)
	cantidad += animalGato(10)
	cantidad += animalHamster(5)
	cantidad += animalTarantula(8)

	fmt.Println("Cantidad de alimento que se debe comparar:", cantidad, "Kg")
}

func perro(cantidadPerros float64) float64 {
	total := cantidadPerros * 10
	return total
}

func gato(cantidadGatos float64) float64 {
	total := cantidadGatos * 5
	return total
}

func hamster(cantidadGatos float64) float64 {
	total := (cantidadGatos / 1000) * 250
	return total
}

func tarantula(cantidadGatos float64) float64 {
	total := (cantidadGatos / 1000) * 150
	return total
}

func animal(animal string) (func(float64) float64, error) {

	switch animal {
	case "perro":
		funcionPerro := perro
		return funcionPerro, nil
	case "gato":
		funcionGato := gato
		return funcionGato, nil
	case "hamster":
		funcionHamster := hamster
		return funcionHamster, nil
	case "tarantula":
		funcionTarantula := tarantula
		return funcionTarantula, nil
	default:
		return nil, errors.New("El animal no existe")
	}

}
