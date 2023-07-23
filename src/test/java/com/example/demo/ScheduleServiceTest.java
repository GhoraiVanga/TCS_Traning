package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ScheduleServiceTest {

    @Test
    public void doSchedule()
    {
        boolean actual = Boolean.TRUE;
        ScheduleService scheduleService = new ScheduleService();

        assertTrue(scheduleService.doSchedule());
    }


    @Test
     public void backupCalendar()
    {
        ScheduleService scheduleService = new ScheduleService();
        assertTrue(scheduleService.backupCalendar());
    }


}
