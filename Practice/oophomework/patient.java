
public class Patient {

	private int patientId;				// 환자 등록번호
	private double temperature;			// 환자 체온
	private int bloodPressureHigh;	// 환자 혈압(위)
	private int bloodPressurLow;	 	// 환자 혈압(아래)
	
	public Patient(int patientId, double temperature, int blood_pressure_high, int blood_pressur_low) {
		super();
		this.patientId = patientId;
		this.temperature = temperature;
		this.bloodPressureHigh = blood_pressure_high;
		this.bloodPressurLow = blood_pressur_low;
	}
	public int getPatientId() {
		return patientId;
	}
	public double getTemperature() {
		return temperature;
	}
	public int getBloodPressure_high() {
		return bloodPressureHigh;
	}
	public int getBloodPressur_low() {
		return bloodPressurLow;
	}


}
