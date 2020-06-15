package com.proyecto.integrado.yodono.jobs;

import com.proyecto.integrado.yodono.repository.DonacionRepository;
import com.proyecto.integrado.yodono.model.type.EstadoDonacion;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import static java.time.temporal.ChronoUnit.HOURS;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskSchedulers{
    Logger logger = LoggerFactory.getLogger(TaskSchedulers.class);
    
    @Autowired
    private final DonacionRepository donacionRepository;
    private  static Integer PARAMETRO_HORA_MAXIMA = 48;

    public TaskSchedulers(DonacionRepository donacionRepository) {
        this.donacionRepository = donacionRepository;
    }

    @Scheduled(cron = "0 * * * * *")
    @SchedulerLock(name = "ExecuteTask", lockAtLeastFor = "15S", lockAtMostFor = "20S")
    public void executeTask() throws InterruptedException {
      List<Long> idDonaciones  = getCancelarDonaciones();
            if(!idDonaciones.isEmpty()){
            logger.info("Id donaciones canceladas {}",idDonaciones);
            }
        Thread.sleep(1000L);
    }

    private List<Long> getCancelarDonaciones() {
        return donacionRepository.findAllByEstadoPendiente()
                  .stream()
                  .filter(pt ->  HOURS.between(pt.getFechaCreacion(), LocalDateTime.now()) > PARAMETRO_HORA_MAXIMA)
                  .map(donacion -> {
                      donacion.setEstado(EstadoDonacion.CANCELADO.name());
                      donacion.setDescripcion(donacion.getDescripcion() + "\n" +String.format("La donacion se ha cancelado, no fue aceptada en %s horas",PARAMETRO_HORA_MAXIMA));
                      return  donacion;
                  }).map(pt -> donacionRepository.save(pt))
                  .map(pt -> pt.getId())
                  .collect(Collectors.toList());
    }
}
