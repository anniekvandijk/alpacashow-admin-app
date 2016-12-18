import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
    name: 'toarray'
})
export class ToArrayPipe implements PipeTransform {
    transform(val) {
        return Array.isArray(val)
            ? val : [ val ];
    }
}