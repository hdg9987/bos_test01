package com.ying96.repository;

        import com.ying96.domain.base.Standard;
        import org.springframework.data.jpa.repository.JpaRepository;

        import java.util.List;

/**
 * Created by dell on 2017/9/14.
 */
public interface StandardRepository extends JpaRepository<Standard,Integer>{

    List<Standard> findByName(String name);
}
