package org.optaplanner.openshift.employeerostering.shared.roster.view;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.openshift.employeerostering.shared.employee.Employee;
import org.optaplanner.openshift.employeerostering.shared.roster.RosterState;
import org.optaplanner.openshift.employeerostering.shared.spot.Spot;

public class AbstractRosterView implements Serializable {

    @NotNull
    protected Integer tenantId;
    @NotNull
    protected LocalDate startDate; // inclusive
    @NotNull
    protected LocalDate endDate; // inclusive
    @NotNull
    protected List<Spot> spotList;
    @NotNull
    protected List<Employee> employeeList;
    @NotNull
    protected RosterState rosterState;

    private HardSoftScore score = null;

    @Override
    public String toString() {
        return startDate + " to " + endDate;
    }

    // ************************************************************************
    // Simple getters and setters
    // ************************************************************************

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<Spot> getSpotList() {
        return spotList;
    }

    public void setSpotList(List<Spot> spotList) {
        this.spotList = spotList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public HardSoftScore getScore() {
        return score;
    }

    public void setScore(HardSoftScore score) {
        this.score = score;
    }

    public RosterState getRosterState() {
        return rosterState;
    }

    public void setRosterState(RosterState rosterState) {
        this.rosterState = rosterState;
    }

}
