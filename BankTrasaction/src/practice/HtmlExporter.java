package practice;

public class HtmlExporter implements Exporter {
	@Override
	public String export(final SummaryStatistics summaryStatistics) {
		
		String result = "<!doctype html>";
		result += "<html lang = 'en'>";
		result += "<head><title>Bank Transaction Report</title></head>";
		result += "<body>";
		result += "<ul>";
		result += "<li><string>The sum is</strong>: " + summaryStatistics.getSum() + "</li>";
		result += "<li><string>The average is</strong>: " + summaryStatistics.getAverage() + "</li>";
		result += "<li><string>The max is</strong>: " + summaryStatistics.getMax() + "</li>";
		result += "<li><string>The min is</strong>: " + summaryStatistics.getMin() + "</li>";
		result += "</ul>";
		result += "</body>";
		result += "</html>";
		
		return result;
	}
}
