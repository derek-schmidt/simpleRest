package api.controller;

import api.domain.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import api.repo.FileRepository;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(path="/file")
public class FileController {
    @Autowired

    private FileRepository fileRepository;

    @RequestMapping(method=POST)
    public @ResponseBody String addNewFile(@RequestBody File input) {
        File file = new File();
        file.setName(input.getName());
        fileRepository.save(file);
        return String.format("New File created id: %d", file.getId());
    }

    @RequestMapping(method=GET)
    public @ResponseBody Iterable<File> getAllNewFile() {
        return fileRepository.findAll();
    }
}
