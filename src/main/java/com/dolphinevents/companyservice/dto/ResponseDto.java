package com.dolphinevents.companyservice.dto;

public class ResponseDto {

    public ResponseDto() {

    }

    private EventsDto event;

    private CompanyDto company;

    /*private List<EventsDto> allEvents; */

    public ResponseDto(EventsDto event, CompanyDto company) {
        this.event = event;
        this.company = company;
    }

    public EventsDto getEventsDto() {
        return event;
    }

    public void setEventsDto(EventsDto event) {
        this.event = event;
    }

    public CompanyDto getCompanyDto() {
        return company;
    }

    public void setCompanyDto(CompanyDto company) {
        this.company = company;
    }

    

    
}
