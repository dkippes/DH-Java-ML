package main

import (
	"io/ioutil"
	"log"
)


func main(){
	producto := "{id: 1, nombre: shampoo, precio: $100, cantidad: 10};{id: 2, nombre: cepillo, precio: $50, cantidad: 12};{id: 2, nombre: jabon, precio: $75, cantidad: 21}"
	archivo := []byte(producto)
	err := ioutil.WriteFile("./listadoProductos.txt", archivo, 0644)
	if err != nil {
		log.Fatal(err)
	}
}
