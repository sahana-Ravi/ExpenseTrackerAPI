package com.roadmap.sh.AdvancedTrackerApi.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component(value = "auditAwareImpl")
public class AuditAwareImpl implements AuditorAware {
    @Override
    public Optional getCurrentAuditor() {
        return Optional.of("RoadMap_sh");
    }
}
