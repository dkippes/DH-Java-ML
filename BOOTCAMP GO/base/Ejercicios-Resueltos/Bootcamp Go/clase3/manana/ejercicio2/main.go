package main

import (
	"fmt"
	"io/ioutil"
	"log"
)

func main(){
	datosBytes, err := ioutil.ReadFile("./listadoProductos.txt")
	if err!=nil{
		log.Fatal(err)
	}
	datosString := string(datosBytes)
	fmt.Println(datosString)
}
