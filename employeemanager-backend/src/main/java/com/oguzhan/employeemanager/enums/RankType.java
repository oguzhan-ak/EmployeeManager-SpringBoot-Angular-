package com.oguzhan.employeemanager.enums;

public enum RankType {
    SERGEANT("SERGEANT"),
    PETTY_OFFICER("PETTY_OFFICER"),
    SOLDIER("SOLDIER");

    private String rankTypeName;

    RankType(String rankTypeName) {
        this.rankTypeName = rankTypeName;
    }

    public String getRankTypeName() {
        return rankTypeName;
    }
}
