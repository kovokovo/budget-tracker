package com.example.racun.dao;


import com.example.racun.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface Racuni extends JpaRepository<Racun, Long> {


}