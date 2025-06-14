package util;

import java.text.DecimalFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Clase utilitaria para manejar operaciones comunes con fechas.
 */
public class LibreriaFechas {

	/**
	 * Convierte una cadena de texto en un objeto LocalDate. Acepta formatos como
	 * "dd/MM/yyyy" o "yyyy-MM-dd".
	 *
	 * @param fechaString fecha en forma de cadena
	 * @return objeto LocalDate o null si el formato es incorrecto
	 */
	public static LocalDate convierteStringToLocalDate(String fechaString) {
		try {
			if (fechaString.contains("/")) {
				String[] arrayFecha = fechaString.split("/");
				return LocalDate.of(Integer.parseInt(arrayFecha[2]), Integer.parseInt(arrayFecha[1]),
						Integer.parseInt(arrayFecha[0]));
			} else if (fechaString.contains("-")) {
				return LocalDate.parse(fechaString);
			} else {
				return null;
			}
		} catch (DateTimeException | ArrayIndexOutOfBoundsException | NullPointerException | NumberFormatException e) {
			return null;
		}
	}

	/**
	 * Verifica si una cadena representa una fecha válida en formato conocido.
	 *
	 * @param fechaString texto a validar
	 * @return true si es una fecha válida, false si no
	 */
	public static boolean isFechaCorrecta(String fechaString) {
		try {
			if (convierteStringToLocalDate(fechaString) == null)
				return false;

			if (fechaString.contains("/")) {
				LocalDate.parse(fechaString, DateTimeFormatter.ofPattern("d/M/yyyy"));
			} else if (fechaString.contains("-")) {
				LocalDate.parse(fechaString);
			} else {
				return false;
			}
		} catch (DateTimeParseException e) {
			return false;
		}
		return true;
	}

	/**
	 * Devuelve la fecha en formato corto "dd/MM/yyyy".
	 *
	 * @param fecha fecha a formatear
	 * @return cadena de texto con la fecha o cadena vacía si es null
	 */
	public static String getFechaShort(LocalDate fecha) {
		if (fecha == null)
			return "";
		return fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	/**
	 * Devuelve la fecha en formato largo.
	 *
	 * @param fecha fecha a formatear
	 * @return fecha en formato extendido o cadena vacía si es null
	 */
	public static String getFechaFull(LocalDate fecha) {
		if (fecha == null)
			return "";
		return fecha.format(DateTimeFormatter.ofPattern("EEEE',' d 'de' MMMM 'de' yyyy"));
	}

	/**
	 * Calcula la edad en años a partir de una fecha de nacimiento.
	 *
	 * @param fechaNacimiento fecha de nacimiento
	 * @return número de años desde esa fecha hasta hoy
	 */
	public static int getEdad(LocalDate fechaNacimiento) {
		return (int) ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now());
	}

	/**
	 * Suma una cantidad de días a una fecha dada.
	 *
	 * @param fechaInicio fecha base
	 * @param dias        número de días a sumar
	 * @return nueva fecha con los días añadidos
	 */
	public static LocalDate sumaDias(LocalDate fechaInicio, int dias) {
		return fechaInicio.plusDays(dias);
	}

	/**
	 * Devuelve una lista con las 7 fechas (de lunes a domingo) de una semana
	 * específica del año.
	 *
	 * @param numSemana número de la semana (1–53)
	 * @param año       el año en curso
	 * @return lista de 7 fechas (una por cada día de la semana)
	 */
	public static List<LocalDate> getDiasSemana(int numSemana, int año) {
		LocalDate fechaInicioSemana = LocalDate.ofYearDay(año, 1)
				.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)).plusWeeks(numSemana - 1);

		List<LocalDate> diasSemana = new ArrayList<>();
		for (int i = 0; i < 7; i++) {
			diasSemana.add(fechaInicioSemana.plusDays(i));
		}
		return diasSemana;
	}

	/**
	 * Devuelve el número de semana del año para una fecha concreta.
	 *
	 * @param fecha fecha a consultar
	 * @return número de la semana (1–53)
	 */
	public static int getNumeroSemana(LocalDate fecha) {
		WeekFields weekFields = WeekFields.of(Locale.getDefault());
		return fecha.get(weekFields.weekOfWeekBasedYear());
	}

	/**
	 * Devuelve una cadena de fecha compacta sin delimitadores, útil para
	 * identificadores. Formato: yyyyMMddmmss
	 *
	 * @param fecha objeto LocalDateTime
	 * @return cadena sin símbolos: ejemplo "202406021745"
	 */
	public static String getFechaSinDelimitadores(LocalDateTime fecha) {
		DecimalFormat patron = new DecimalFormat("00");
		return "" + fecha.getYear() + patron.format(fecha.getMonthValue()) + patron.format(fecha.getDayOfMonth())
				+ patron.format(fecha.getMinute()) + patron.format(fecha.getSecond());
	}

	/**
	 * Método pendiente de implementación. Se puede usar para formatear una fecha
	 * desde texto libre.
	 *
	 * @param string texto a transformar
	 * @return por ahora null
	 */
	public static String transformaFecha(String string) {
		return null;
	}
}
