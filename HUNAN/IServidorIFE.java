import java.util.ArrayList;


public interface IServidorIFE {

	/**
	 * Devuelve una lista con los pasajeros del avion
	 * <b>Pre:</b> La base de datos de pasajeros ha sido previamente cargada
	 * <b>Pos:</b> Se ha retornado una lista con los pasajeros del avion
	 * @return ArrayList<IPasajero> : una lista con los pasajeros
	 */
	public ArrayList<IPasajero> darListaPasajeros();
	
	/**
	 * Dado el identificador de la silla de un pasajaro cuya terminal ha sido bloqueada, este metodo la desbloquea
	 * <b>Pre:</b> La pantalla del pasajero indicado esta bloqueada
	 * <b>Pos:</b> La pantalla ha sido desbloqueada y el usuario puede utilizarla
	 * @param idSilla: el identificador unico de la silla del pasajero
	 */
	public void desbloquearUsuario(String idSilla);
	
	/**
	 * Despues de bloquear todos los usuarios (por ejemplo para hacer un anuncio general) este metodo desbloquea sus pantallas
	 * <b>Pre:</b> Las pantallas de todos los pasajeros han sido bloqueadas
	 * <b>Pos:</b> Las pantallas de todos los usuarios estan listas para ser utilizadas
	 */
	public void desbloquearUsuarios();
	
	/**
	 * Cuando un usuario quiere comprar un producto por tarjeta de credito 
	 * <b>Pre:</b> El usuario ha solicitado un producto o servicio cuyo pago se puede realizar por tarjeta de credito y la informacion financiera de todos los usuarios ha sido cargada desde la base de datos
	 * <b>Pos:</b> De acuerdo a la informacion financiera asociada al pasajero el gasto se le ha cargado (o no en caso de no ser posible) a su tarjeta de credito
	 * @param idSilla: El identificador de la silla del usuario que realiza el pago
	 * @param idItem: El identificador del item que el usuario desea comprar
	 */
	public void hacerPagoTarjeta(String idSilla, String idItem);
	
	/**
	 * Se retorna un listado con el nombre de los juegos disponibles
	 * <b>Pre:</b> Se ha cargado la base de datos con los juegos
	 * <b>Pos:</b> Se devuelve un listado con los nombres de los juegos disponibles para los usuarios
	 * @return ArrayList<String> : un listado con los nombres de los juegos
	 */
	public ArrayList<String> listarNombreJuegos();
	
	/**
	 * Se devuelve un listado con los multimedias de un tipo en especial que se pasa por parametro (peliculas, series, musica, etc...)
	 * <b>Pre:</b> Se ha cargado la base de datos con los multimedias, el tipo que se pasa por parametro es un tipo valido
	 * <b>Pos:</b> Se ha retornado un arreglo con los multimedia del tipo que se paso por parametro
	 * @param tipo: El tipo de multimedia que se desea listar
	 * @return ArrayList<IMultimedia>: un listado de los multimedias del tipo deseado
	 */
	public ArrayList<IMultimedia> listarVideosPorMultimedia(String tipo);
	
	public void notificarAzafata(String idSilla, String nombre);
	
	public void notificarVisualAzafata(IPasajero pasajero);
	
	public void notificarVisualPasajero(String tipoPasajero);
	
	/**
	 * Toma el control de la terminal de un pasajero 
	 * <b>Pre:</b> Se ha cargado la base de datos de pasajeros
	 * <b>Pos:</b> El personal de vuelo puede manipular remotamente la pantalla del usuario
	 * @param idSilla: El identificador de la silla del pasajero
	 */
	public void tomarControlIPasajero(String idSilla);
	
	/**
	 * Dada la id del pasaje de un pasajero verifica si pago adjunto la visualizacion de canales online
	 * <b>Pre:</b> Se ha cargado la base de datos con la informacion de los usuarios
	 * <b>Pos:</b> Se devuelve true si efectivamente al comprar el pasaje el pasajero tambien compro los canales online
	 * @param idPasaje: El identificador del pasaje del usuario
	 * @return boolean: true si el usuario junto al pasaje compro los canales online
	 */
	public boolean verificarPagoCanalesOnlinePasaje(String idPasaje);
	
}
