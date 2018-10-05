package web.vote;

import model.Vote;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "ajax/votes")
public class VoteAjaxController extends AbstractVoteController {


    @Override
    @PostMapping(value = "create/{id}")
    public Vote create(@PathVariable("id") int restaurantId) {
        return super.create(restaurantId);
    }

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vote> getAll() {
        return super.getAll();
    }

}