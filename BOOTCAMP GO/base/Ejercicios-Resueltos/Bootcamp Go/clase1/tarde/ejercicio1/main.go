package main

import (
	"fmt"
)

func main() {

	var palabra string = "esternocleidomastoideo"

	lenpalabra := len(palabra)

	fmt.Println("Cantidad de letras: ", lenpalabra)

	for i := 0; i < len(palabra); i++ {
		fmt.Println(string(palabra[i]))
	}

}
