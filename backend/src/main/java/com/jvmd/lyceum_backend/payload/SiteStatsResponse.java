package com.jvmd.lyceum_backend.payload;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SiteStatsResponse {
    private long newsCount;
    private long achievementsCount;
    private long portfolioCount;
    private long applicationsCount;
}
