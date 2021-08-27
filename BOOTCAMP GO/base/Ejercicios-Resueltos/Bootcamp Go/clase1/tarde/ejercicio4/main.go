package main

import (
	"fmt"
)

func main() {
	var Mes int = 5
	Meses := make(map[int]string)
	MesesTexto := []string{"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}
	for i := 0; i < len(MesesTexto); i++ {
		Meses[i] = MesesTexto[i]
	}
	fmt.Println(Meses[Mes-1])
}
